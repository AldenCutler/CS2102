class ReadingResult implements IChallenge {


    int bookspd;
    booksread br;

    ReadingResult (Integer bookspd, booksread br) {
        this.bookspd = bookspd;
        this.br = br;
    }

    public double averagePerDay() {
        return (br.booksreadfiction + br.booksreadnonfiction)/31;
    }

    public double differenceFromGoal() {
        return bookspd - averagePerDay();
    }
}
