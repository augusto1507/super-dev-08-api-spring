export interface CategoriaCadastrarRequest {
    nome: string;
    descricao: string;
}

export interface CategoriaResponse{
    id: number;
    nome: string;
    descricao: string;
    ativa: boolean;
}

export interface categoriaEditarRequest{
    nome: string,
    descricao: String
}