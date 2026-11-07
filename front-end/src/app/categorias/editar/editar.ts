import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { categoriaEditarRequest } from '../../model/categoria.model';
import { CategoriaService } from '../../services/categoria.service';
import { ActivatedRoute,  Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-editar',
  imports: [FormsModule, RouterLink],
  templateUrl: './editar.html',
  styleUrl: './editar.css',
})
export class CategoriaEditar {

  id: number | undefined = undefined

  form = signal<categoriaEditarRequest>({
    nome: "",
    descricao: ""
  });

  constructor(
    private categoriaService: CategoriaService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ){
    this.id = parseInt(
      this.activatedRoute.snapshot.paramMap.get('id')!
    )
  }

  ngOnInit(): void{
    this.carregarCategoria()
  }

  private carregarCategoria(){
    this.categoriaService.obterPorId(this.id!).subscribe({
      next: (dado) => {
        this.form.update(formAtual => ({
          ...formAtual,
          nome: dado.nome,
          descricao: dado.descricao
        }));
      }
    });
  }

  editar(): void{
    this.categoriaService.editar(this.id!, this.form()).subscribe({
      next: () => {
        alert("Categoria editada com sucesso")
        this.router.navigate(['/categorias'])
      },
      error: () => {
        console.error("Deu merda em editar parceiro");
        alert("Erro ao editar o aluno")
      }
    })
  }
}
