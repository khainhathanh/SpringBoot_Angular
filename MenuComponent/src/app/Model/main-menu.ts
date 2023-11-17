import { ChildMenu } from "./child-menu";

export class MainMenu {
    id: number;
    name: string;
    child: Array<ChildMenu>

    constructor(id: number,name: string, child: Array<ChildMenu> ){
        this.id = id;
        this.name = name;
        this.child = child;
    }

}
