import { Routes } from '@angular/router';
import { CategoriaCadastrar } from './categorias/cadastrar/cadastrar';
import { CategoriaListar } from './categorias/listar/listar';
import { CategoriaEditar } from './categorias/editar/editar';

export const routes: Routes = [

    {path: 'categorias/cadastrar', component:CategoriaCadastrar},

    {path: 'categorias', component:CategoriaListar},

    {path: 'categorias/editar/:id', component:CategoriaEditar}

];
