/**
 * Пример ходов шахматных фигур, фигуры в enum, как и доска.
 * Доска 8*8, Фигуры писать корректно:
 * king	[ kɪŋ ]	король
 * queen	[ kwiːn ]	королева
 * bishop	[ ˈbɪʃəp ]	слон
 * knight	[ naɪt ]	конь
 * rook / castle	[ rʊk ] [ ˈkɑːsl̩ ]	ладья
 * pawn	[ pɔːn ]	пешка
 */

public class сhessMove {
    public static void main(String[] args) {
        canMove("Rook", "A8", "H8");
        canMove("Bishop", "A7", "G1");
        canMove("Queen", "C4", "D6");




    }

    public static boolean canMove(String s1, String s2, String s3) {
        //стартовая позиция, метод valueOf преобразует в имя enum
        cellChess start = cellChess.valueOf(s2);
        //куда хочет перейти
        cellChess move = cellChess.valueOf(s3);
        //Делаем все заглавные, дли избежания ошибок ввода
        s1=s1.toUpperCase();
//TODO:Реализуем ладью - Rook
        //ходит по вертикали и горизонтали
        if (Figure.ROOK == Figure.valueOf(s1) && (start.getX() - move.getX() == 0 || start.getY() - move.getY() == 0)) {
            System.out.println(s1 + " true, can move");
            return true;

        }
//TODO:реализуем пешку - Pawn
        //ходит вперед на 1 шаг
        if (Figure.PAWN == Figure.valueOf(s1) && (move.getY() == start.getY() + 1 && start.getX() == move.getX())) {

        }
//TODO:реализуем слона - Bishop
        // Поскольку слон может перемещать только диагонали
        if (Figure.BISHOP == Figure.valueOf(s1) && Math.abs(start.getX() - move.getX()) == Math.abs(start.getY() - move.getY())) {
            System.out.println(s1 + " true, can move");
            return true;
        }
//TODO:Реализуем короля - King
        //Проанализируем ход. Король может ходить вверх вниз, вправо влево и по диагонали но только на одну клетку.
        // Т.е. если разность между координатами X и Y
        // будет составлять 1 или -1 (в случае если переходит с меньшей координаты на большую)
        // или разность одной из координат равна 0 то соответственно
        // король может перейти с первой клетки на вторую.
        if (Figure.KING==Figure.valueOf(s1) &&  Math.abs(start.getX()- move.getX())<=1
                && Math.abs(start.getY()- move.getY())<=1){
            System.out.println(s1 + " true, can move");
            return true;

        }
        //TODO: Реализуем ферзя
        //Проанализируем ход ферзя. Эта фигура ходит как король,
        // но уже на любое доступное количество клеток, ну или можем сказать,
        // что ферзь ходит и как ладья и как слон,
        // мы уже анализировали и писали код для этих фигур поэтому просто объединим
        // два условия в одно
        if (Figure.QUEEN==Figure.valueOf(s1)&&Math.abs(start.getX()- move.getX())<=1
                && Math.abs(start.getY()- move.getY())<=1
                || start.getX() - move.getX() == 0
                || start.getY() - move.getY() == 0){
            System.out.println(s1 + " true, can move");
            return true;
        }
        //TODO: Реализуем Коня
        //Самая интересная фигура. Проанализировав ход коня буквой "Г"
        // можно увидеть что если конь ходит вниз или вверх буквой то его координата по X меняется на 1 а координата по Y на 2,
        // если влево и вправо то наоборот X на 2 а Y на 1.
        // Исходя из этого можно написать код, что если разность координат X1 и X2 уменьшилась или увеличилась на 1
        // и при этом разность координат Y1 и Y2 уменьшалась или увеличилась на 2
        // или если разность координат X1 и X2 уменьшилась или
        // увеличилась на 2 и при этом разность координат Y1 и Y2 уменьшалась или увеличилась на 1
        int dx = Math.abs(start.getX() - move.getX()); // модуль разницы координат X
        int dy = Math.abs(start.getY() - move.getY()); //модуль разницы координат Y
        if (Figure.KNIGHT == Figure.valueOf(s1) && dx==1 && dy==2||
        dx==2 &&dy==1){
            System.out.println(s1 + " true, can move");
            return true;
        }
        System.out.println(s1 + " Can`t move");

        return false;


    }


}


