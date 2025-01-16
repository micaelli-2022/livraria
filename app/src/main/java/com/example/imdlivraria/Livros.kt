package com.example.imdlivraria

class Livros
    (var titulolivro:String = "", var autorlivro:String = "", var editoralivro:String = "", var isbn :Int = 0,  var descricaolivro: String = "", var url: String = ""){

    override fun toString(): String {
        return "titulo: $titulolivro \nautor: $autorlivro \neditora: $editoralivro \nisnb: $isbn \ndescrição: $descricaolivro \nurl: $url\n"


    }
}