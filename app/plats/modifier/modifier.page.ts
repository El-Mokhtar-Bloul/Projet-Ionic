import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlatsService } from './../../services/plats.service';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Plat } from 'src/app/Models/plat';
import { ToastController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modifier',
  templateUrl: './modifier.page.html',
  styleUrls: ['./modifier.page.scss'],
})
export class ModifierPage implements OnInit {
  
  nomControl: FormControl;
  prixControl: FormControl;
  descriptionControl: FormControl;
  formGroup: FormGroup;
  platId: number;
  plat:Plat;
  
    constructor(private builder: FormBuilder,public toastController: ToastController,private route: ActivatedRoute,private rout: Router, private service: PlatsService)
      {
        this.platId = Number(this.route.snapshot.paramMap.get('id'));
      
      this.service.get(this.platId).subscribe(plat => {
        this.plat = plat;
        this.nomControl = new FormControl(this.plat.nom, [Validators.required,Validators.minLength(2)]);
        this.prixControl = new FormControl(this.plat.prix, Validators.required);
        this.descriptionControl = new FormControl(this.plat.description);
        this.formGroup = this.builder.group({
          nom: this.nomControl,
          prix: this.prixControl,
          description: this.descriptionControl
        })
      
      })
     }
     ngOnInit(){}
     async presentToast(message: string)
     {
          const toast = await this.toastController.create({
              message: message,
              duration:2000,
              color:'success',
              position:'top'
          });
          toast.present();
     }

     modifier(): void
        {
         
          this.service.update(this.plat.id,this.formGroup.value).subscribe(plat  => {
            this.presentToast("Plat Modifier avec succès. ");
            this.rout.navigate(['/tabs/plats']);
          })
        }
  
}
