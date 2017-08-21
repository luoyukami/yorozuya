import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.scss']
})
export class DemoComponent implements OnInit, AfterViewInit, OnDestroy {
  public editor;

  constructor(private http: Http) { }

  ngOnInit() {
  }
  // 文件上传函数，暂时只支持了图片类型，tinymce可以支持更多。使用原生的写法，之后考虑用http模块改写
  public fileInputChangeHandler(): void {
    let fileInput = <HTMLInputElement>document.getElementById('img_input');
    let inputValue = fileInput.value;
    if (!inputValue) {
      return;
    }
    let fileForm = <HTMLFormElement>document.getElementById('file_upload_form');
    fileForm.action = 'yorozuya/imageUpload';
    fileForm.onsubmit = (event) => {
      // 关闭默认事件效果
      event.preventDefault();
      let file = fileInput.files[0];
      let formData = new FormData();
      formData.append('file', file, file.name);
      // xhr
      // let xhr=new XMLHttpRequest();
      // xhr.withCredentials = false;
      // xhr.open('POST', 'yorozuya/fileUpload');
      // xhr.onload = function() {
      //   let json;
      //   if (xhr.status != 200) {
      //     console.log('HTTP Error: ' + xhr.status);
      //     return;
      //   }
      //   json = JSON.parse(xhr.responseText);
      //   if (!json || typeof json.location != 'string') {
      //     console.log('Invalid JSON: ' + xhr.responseText);
      //     return;
      //   }
      //   console.log(json.location);
      //   fileInput.value='';
      // };
      // xhr.send(formData);

      // Http
      this.http.post('yorozuya/fileUpload', formData)
        .map(res => res.json())
        .subscribe(data => {
          if (data) console.dir(data);
        });
    }
    fileForm.submit();
    fileInput.value = '';
  }

  ngAfterViewInit() {
    tinymce.init({
      selector: '#post_editor',
      skin_url: '/assets/skins/lightgray',
      plugins: [
        // 'advlist autolink lists link image charmap print preview hr anchor pagebreak',
        // 'searchreplace wordcount visualblocks visualchars code fullscreen',
        // 'insertdatetime media nonbreaking save table contextmenu directionality',
        // 'emoticons template paste textcolor colorpicker textpattern imagetools codesample',
        // 规则拓展 markdown模式
        'textpattern',
        'image imagetools'
      ],
      textpattern_patterns: [
        {start: '*', end: '*', format: 'italic'},
        {start: '**', end: '**', format: 'bold'},
        {start: '#', format: 'h1'},
        {start: '##', format: 'h2'},
        {start: '###', format: 'h3'},
        {start: '####', format: 'h4'},
        {start: '#####', format: 'h5'},
        {start: '######', format: 'h6'},
        {start: '1. ', cmd: 'InsertOrderedList'},
        {start: '* ', cmd: 'InsertUnorderedList'},
        {start: '- ', cmd: 'InsertUnorderedList'}
      ],
      toolbar1: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
      toolbar2: 'print preview media | forecolor backcolor emoticons | codesample',
      image_advtab: true,
      codesample_content_css: '/assets/css/prism.css',
      // 文件和图片上传相关的选项
      file_browser_callback_types: 'image',
      file_browser_callback: function (field_name, url, type, win) {
        if (type === 'image') {
          let event = new MouseEvent('click', {
            'view': window,
            'bubbles': true,
            'cancelable': true
          });
          let fileInput = document.getElementById('img_input');
          fileInput.dispatchEvent(event);
        }
      }
    });
  }
  ngOnDestroy() {
    tinymce.remove(this.editor);
  }
}
