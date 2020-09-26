import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Utilisateur} from '../Models/utilisateur';
import { Router } from '@angular/router';
import { UtilsService } from 'src/app/utils.service';
@Component({
 selector: 'app-register',
 templateUrl: './register.page.html',
 styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {
 registerForm: FormGroup;
 constructor(private formBuilder: FormBuilder, private service: AuthService,
private route: Router,
 private utils: UtilsService) { }
 ngOnInit() {
 this.registerForm = this.formBuilder.group({
 'username' : [null, [Validators.required,Validators.minLength(3)]],
 'email' : [null, [Validators.required,Validators.email]],
 'password' : [null, [Validators.required]]
 });
 }
register(userInfo: Utilisateur) {
 this.service.register(userInfo).subscribe(data=>{
  this.utils.presentToast('Inscription réussie','success');
  this.route.navigateByUrl('login');
  },error=>{
 
  switch (error.error.message[0].messages[0].id)
  {
  case "Auth.form.error.email.taken":
  this.utils.presentToast('Email déjà utilisé!','danger');
  break;
  case "Auth.form.error.username.taken":
  this.utils.presentToast("Nom d'utilisateur déjà utilisé!",'danger');
  break;
  default:
  this.utils.presentToast('Une erreur est survenue!','danger');
  break;
  }
  });
  }
 }