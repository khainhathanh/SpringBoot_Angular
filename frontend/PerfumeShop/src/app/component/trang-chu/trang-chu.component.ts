import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';

@Component({
  selector: 'app-trang-chu',
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  listPerfume : any[] = [];

  constructor (private perfumeService : PerfumesService){

  }

  getDetailPerfume(){
    this.perfumeService.getAllPerfumes().subscribe((data : any[])=>{
      this.listPerfume = data
      console.log(this.listPerfume)
    })
  }
}
