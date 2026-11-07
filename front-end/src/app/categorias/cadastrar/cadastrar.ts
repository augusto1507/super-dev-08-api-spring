import { Component } from '@angular/core';
import { CategoriaService } from '../../services/categoria.service';
import { CategoriaCadastrarRequest } from '../../model/categoria.model';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-cadastrar',
  imports: [FormsModule, RouterLink],
  templateUrl: './cadastrar.html',
  styleUrl: './cadastrar.css',
})
export class CategoriaCadastrar {

  constructor(private categoriaService: CategoriaService,
    private router: Router
  ){}

  form: CategoriaCadastrarRequest = {
    nome:"",
    descricao:""
  };

  cadastrar(){
    this.categoriaService.cadastrar(this.form).subscribe({
      next: (Response) => {
        alert("Categoria criada com sucesso")
        this.router.navigate(['/categorias'])
      }
    })
  }
}
