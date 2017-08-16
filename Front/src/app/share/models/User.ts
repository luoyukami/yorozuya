/**
 * Created by 落羽 on 2017/8/16.
 */
export interface User {
  userName: string;
  account: {
    email: string;
    password: string;
    confirmPW: string;
  };
}
