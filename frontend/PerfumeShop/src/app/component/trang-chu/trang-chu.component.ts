import { Component } from '@angular/core';
import { PerfumesService } from '../../service/perfumes.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trang-chu',
  templateUrl: './trang-chu.component.html',
  styleUrl: './trang-chu.component.css'
})
export class TrangChuComponent {
  listPerfume : any[] = [];
  listCarousel : any[] = [];

  constructor (private perfumeService : PerfumesService, private router : Router){
    this.getAllPerfume()
    this.getAllCarousels()
  }

  getAllPerfume(){
    this.perfumeService.getAllPerfumes().subscribe((data : any[])=>{
      this.listPerfume = data
    })
  }

  getAllCarousels(){
    this.perfumeService.getAllCarousels().subscribe((data : any[])=>{
      this.listCarousel = data
    })
  }

  getDetailPerfume = ()  => {
    this.router.navigate(['/detail-perfume']);
  }
}
