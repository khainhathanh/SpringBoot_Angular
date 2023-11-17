import { MainMenu } from "./main-menu";

export class ChildMenu {
    id: number;
    name: string;
    mainId: MainMenu;
    projectId: number;

    constructor(id: number, name: string, mainid: MainMenu, projectid: number){
        this.id = id;
        this.name = name;
        this.mainId = mainid;
        this.projectId = projectid;
    }
}
