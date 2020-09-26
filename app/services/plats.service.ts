import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plat } from '../Models/plat';
//import { URL } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class PlatsService {
  
  constructor(private httpClient: HttpClient) { }

  //Méthode d'ajout de plats
  addPlats(plat: Plat): Observable<Plat> {
    return this.httpClient.post<Plat>("http://localhost:1337/Plats", plat).pipe();
  }
  

  get(id: number): Observable<Plat> {
    return this.httpClient.get<Plat>('http://localhost:1337/Plats/'+id).pipe();
  }

  getAll(): Observable<Plat[]> {
    return this.httpClient.get<Plat[]>('http://localhost:1337/Plats/').pipe();
  }

  update(id : number, plat:Plat): Observable<Plat> {
    return this.httpClient.put<Plat>('http://localhost:1337/plats/'+id, plat).pipe();
  }

  delete(id: number): Observable<Plat> {
    return this.httpClient.delete<Plat>('http://localhost:1337/plats/'+id).pipe();
  }






}
