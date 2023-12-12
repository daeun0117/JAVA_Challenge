public class Week_12 {
    static public void main(String[] args) {
        Shape[] list = new Shape[3];
        list[0] = new Circle(5);
        list[1] = new Oval(30, 50);
        list[2] = new Rect(20, 40);

        for (int i = 0; i < list.length; i++)
            list[i].redraw();

        for (int i = 0; i < list.length; i++)
            System.out.println("면적은 " + list[i].getArea());
    }
}