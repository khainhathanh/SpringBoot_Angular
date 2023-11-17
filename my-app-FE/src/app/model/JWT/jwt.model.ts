import { User } from "../User/user.model";
export class JWT{
    user:User;
    jwt:string;
    constructor(user:User,jwt:string){
        this.user =user;
        this.jwt = jwt;
    }
}