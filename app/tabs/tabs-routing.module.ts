import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'menu',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../menu/menu.module').then(m => m.MenuPageModule)
          }
        ]
      },
      {
        path: 'plats',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../plats/plats.module').then(m => m.PlatsPageModule)
          },
        ]
      },
      {
        
        path: 'ajouter',
        children: [
          {
            path: '',
            loadChildren: () =>
              import('../plats/ajouter/ajouter.module').then(m => m.AjouterPageModule)
              }
            ]
       },

          {
          path: 'modifier/:id',
            children: [
               {
                 path: '',
                loadChildren: () =>
                  import('../plats/modifier/modifier.module').then(m => m.ModifierPageModule)
               }
              ],
            },
              {
               
              
          
            path: 'comptes',
            children: [
              {
                path: '',
                loadChildren: () =>
                  import('../comptes/comptes.module').then(m => m.ComptesPageModule)
              }
            ]
          },
    ] 
  },
]
  
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
