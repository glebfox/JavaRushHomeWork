package com.glebfox.test;

/**
 * Created by glebfox on 30.06.14.
 */
public class Program {
    public static void main(String[] args) throws InterruptedException {
//        Base b = new Base(0);
//        Derive d = new Derive(1);
//
//        b.Print();
//        b.VirtualPrint();
//
//        d.Print();
//        d.VirtualPrint();
//
//        b = d;
//        b.Print();
//        b.VirtualPrint();
//
//        b.n = 2;
//        b.Print();
//        b.VirtualPrint();
//
//        d.n = 2;
//        b.Print();
//        b.VirtualPrint();

        String[] items = "1 2  3 ".split(" ");
        for (String item : items)
            System.out.println(item);
    }

    public static class Base {
        protected int n;

        public Base(int n) {
            this.n = n;
        }

        public void Print() {
            System.out.println("Base " + n);
        }

        public void VirtualPrint() {
            System.out.println("VBase " + n);
        }
    }

    public static class Derive extends Base {

        public Derive(int n) {
            super(n);
        }

        public void Print() {
            System.out.println("Derive " + n);
        }

        @Override
        public void VirtualPrint() {
            System.out.println("VDerive " + n);
        }
    }

//    class Parent
//    {
//        private int n;
//        public Parent ()
//        {
//            n = 0;
//        }
//
//        public void Print()
//        {
//            Console.WriteLine ("Parent " + n.ToString());
//        }
//
//        public virtual void VirtualPrint()
//    {
//        Console.WriteLine ("VParent " + n.ToString());
//    }
//    }
//
//    class Child : Parent
//    {
//        private int n;
//
//        public Child ()
//        {
//            n = 1;
//        }
//
//        public new void Print()
//        {
//            Console.WriteLine ("Child " + n);
//        }
//
//    public override void VirtualPrint ()
//    {
//        Console.WriteLine ("VChild " + n.ToString());
//    }
//}
}
