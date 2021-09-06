package projectvendingmachine;

import java.util.Scanner;

public class Methods {

    public double select(Products products){

        System.out.println(products.toString());

        Scanner scan=new Scanner(System.in);

        do {
            System.out.println("Lutfen almak istediginiz urunun numarasinin giriniz ( 1'den 10'a kadar)");
            products.setProductNum(scan.nextInt());
            if (products.getProductNum()<1 ||products.getProductNum()>10 ){
                System.out.println("Gecerli bir product numarasi giriniz(1'den 10'a kadar)");
            }
        }while (products.getProductNum()<1 ||products.getProductNum()>10);

        return 0;
    }
}
