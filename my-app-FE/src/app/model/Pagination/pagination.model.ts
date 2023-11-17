import { Student } from "../Student/student.model";

export class Pagination {
    public content : Array<Student>;
    public totalPage : number;
    constructor(content: Array<Student>, totalPage: number){
        this.content = content;
        this.totalPage = totalPage;
    }
}

