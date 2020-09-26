import { Component } from '@angular/core';
import { PlatsService} from '../services/plats.service';
import { Router } from '@angular/router';
import { Plat } from '../Models/plat';


@Component({
  selector: 'app-plats',
  templateUrl: 'plats.page.html',
  styleUrls: ['plats.page.scss']
})
export class PlatsPage {
  plats: Plat[];


  constructor(private api: PlatsService, private route: Router) {
     this. getAll();

  }

ionViewWillEnter() {
  this.getAll();
}

  modifier(id:any):void {
    this.route.navigate(['/tabs/modifier',id]);
  }

   getAll():void{
       this.api.getAll().subscribe(Response=>{
           this.plats = Response;
       });
   }
  delete(plat: Plat ):void
   {
     this.api.delete(plat.id).subscribe(plat=>{
       this.getAll();
       this.route.navigate(['/tabs/plats']);
     });
   }

  }
