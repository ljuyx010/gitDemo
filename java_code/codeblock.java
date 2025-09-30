class Movie{
    private String name;
    private double price;
    private String director;
    //下面的2个构造器都有相同的语句
    //这样代码看起来比较冗余，可以放入到一个代码块中
    //这样当我们不管调用哪个构造函数，都会调用代码块的内容
    //代码块的执行顺序优先于构造器
    public static void main(String[] args) {
        Movie m1 = new Movie("速度与激情");
        Movie m2 = new Movie("速度与激情",100);
    }

    public Movie(String name){
        this.name = name;
        //System.out.println("荧幕打开...");
        //System.out.println("广告开始...");
        System.out.println("name构造函数...");
    }
    public Movie(String name,double price){
        this.name = name;
        this.price = price;
        //System.out.println("荧幕打开...");
        //System.out.println("广告开始...");
        System.out.println("name和price构造函数...");
    }
    static {
        System.out.println("荧幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影准备播放...");
    };
}