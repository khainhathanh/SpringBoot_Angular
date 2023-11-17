import { Author } from "../Authorize/author.model";
export class User {
     username : string;
     password : string;
     authorities: Array<Author>;
    accountNonExpired: boolean;
    accountNonLocked: boolean;
    credentialsNonExpired: boolean;
    enabled: boolean;
    constructor (username : string, password : string ,authorize:Array<Author>, accountNonExpired: boolean ,accountNonLocked: boolean,credentialsNonExpired: boolean,enabled: boolean){
        this.username = username;
        this.password = password;
        this.authorities = authorize;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
}

