public enum Figure {
    KING("Король"),
    QUEEN("Королева"),
    BISHOP("Слон"),
    KNIGHT("Конь"),
    ROOK("Ладья"),
    PAWN("Пешка");
    String s;
    Figure(String s){
        this.s=s;
    }
}
