import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-trang-chu',
  standalone: true,
  imports:[CommonModule],
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  listPerfume : any[] = [];

  constructor (private perfumeService : PerfumesService){
    this.getDetailPerfume()
  }

  getDetailPerfume(){
    this.perfumeService.getAllPerfumes().subscribe((data : any[])=>{
      this.listPerfume = data
    })
  }
}
