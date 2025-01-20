package com.example.imdlivraria

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LivroAdapter(private val livros: ArrayList<Livros>) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {

    // ViewHolder: gerencia os elementos de cada item da lista
    class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.ed_titulo)
        val autor: TextView = itemView.findViewById(R.id.ed_nome)
        val editora: TextView = itemView.findViewById(R.id.ed_description)
        val isbn: TextView = itemView.findViewById(R.id.ed_isbn)
        val descricao: TextView = itemView.findViewById(R.id.ed_descricao)
        val url: ImageView = itemView.findViewById(R.id.ed_imagem)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livro, parent, false)
        return LivroViewHolder(view)
    }


    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]
        holder.titulo.text = livro.titulolivro
        holder.autor.text = livro.autorlivro
        holder.editora.text = livro.editoralivro
        holder.isbn.text = livro.isbnlivro.toString()
        holder.descricao.text = livro.descricaolivro

        Glide.with(holder.itemView.context)
            .load(livro.urllivro) // URL da imagem
            .into(holder.url)


    }




    // Retorna o número total de itens na lista
    override fun getItemCount(): Int {
        return livros.size
    }
}