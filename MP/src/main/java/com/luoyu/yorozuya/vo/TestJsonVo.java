package com.luoyu.yorozuya.vo;

import java.io.Serializable;

/**
 * Created by 落羽 on 2017/8/22.
 */
public class TestJsonVo implements Serializable {
    private int id;
    private String name;
    private String sex;
    private long age;
    private hobby hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public TestJsonVo.hobby getHobby() {
        return hobby;
    }

    public void setHobby(TestJsonVo.hobby hobby) {
        this.hobby = hobby;
    }

    public TestJsonVo() {
       this.hobby = new hobby();
    }

    @Override
    public String toString() {
        return "2333";
    }

    public class hobby {
        private String music;
        private String sports;
        private String game;

        public String getMusic() {
            return music;
        }

        public void setMusic(String music) {
            this.music = music;
        }

        public String getSports() {
            return sports;
        }

        public void setSports(String sports) {
            this.sports = sports;
        }

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        @Override
        public String toString() {
            return "hobby{" +
                    "music=" + music +
                    "}";
        }
    }
}
