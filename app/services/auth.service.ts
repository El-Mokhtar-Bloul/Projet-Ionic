import { Injectable } from '@angular/core';
import { Utilisateur} from '../Models/utilisateur';
import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
const TOKEN_KET ='user-access-token';
@Injectable({
 providedIn: 'root'
})

 export class AuthService {
redirectUrl: string;  

 constructor(private http: HttpClient) { } 
       
login(user : Utilisateur): Observable<Utilisateur>  {   
      return this.http.post<Utilisateur>("http://localhost:1337/User",user).pipe();   
    } 

register(user: Utilisateur)  : Observable<Utilisateur> { 

      return this.http.post<Utilisateur>("http://localhost:1337/User",user).pipe(); 
      } 
    }