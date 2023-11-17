export class ChildMenu {
    id: number;
    name: string;
    mainId: number;
    projectId: number;

    constructor(id: number, name: string, mainid: number, projectid: number){
        this.id = id;
        this.name = name;
        this.mainId = mainid;
        this.projectId = projectid;
    }
}
