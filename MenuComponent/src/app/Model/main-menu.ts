import { ChildMenu } from "./child-menu";

export class MainMenu {
    id: number;
    name: string;
    listChild: Array<ChildMenu>
    constructor(id: number,name: string , listChild: Array<ChildMenu> ){
        this.id = id;
        this.name = name;
        this.listChild = listChild;
    }

}
