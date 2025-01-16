package com.example.imdlivraria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroAdapter(private val livros: ArrayList<Livros>) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    // ViewHolder: gerencia os elementos de cada item da lista
    class LivroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.ed_titulo)
        val autor: TextView = view.findViewById(R.id.ed_nome)
        val editora: TextView = view.findViewById(R.id.ed_description)
        val isbn: TextView = view.findViewById(R.id.ed_isbn)
        val descricao: TextView = view.findViewById(R.id.ed_descrição)
        val url: TextView = view.findViewById(R.id.ed_url)


    }

    // Infla o layout de cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livro, parent, false)
        return LivroViewHolder(view)
    }

    // Vincula os dados de um objeto Livros ao layout
    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.titulo.text = livro.titulolivro
        holder.autor.text = livro.autorlivro
        holder.editora.text = livro.editoralivro
        holder.isbn.text = livro.isbn.toString()
        holder.descricao.text = livro.descricaolivro
        holder.url.text = livro.url
    }


    fun updateList(newLivros: ArrayList<Livros>) {
        livros.clear()
        livros.addAll(newLivros)
        notifyDataSetChanged()  // Notifica o RecyclerView para atualizar a lista
    }
    // Retorna o número total de itens na lista
    override fun getItemCount(): Int {
        return livros.size
    }
}