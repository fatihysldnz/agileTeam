package projectvendingmachine;

import java.util.Scanner;

public class Methods {

    public double money(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ne kadar para yatirmak istersiniz?");
        double money= scan.nextDouble();
        return money;
    }

    public double select(Products products){

        System.out.println(products.toString());

        Scanner scan=new Scanner(System.in);

        do {
            System.out.println("Lutfen almak istediginiz urunun numarasinin giriniz ( 1'den 10'a kadar)");
            System.out.println("Cikis icin 0'a basiniz");
            products.setProductNum(scan.nextInt());
            if (products.getProductNum()<0 ||products.getProductNum()>10 ){
                System.out.println("Gecerli bir product numarasi giriniz(1'den 10'a kadar)");
            }
        }while (products.getProductNum()<0 ||products.getProductNum()>10);

        switch (products.getProductNum()){
            case 0:
                System.out.println("tesekkur eder tekrar bekleriz...");
            break;
                case 1:
                products.setPrice(products.getSnicker());
            break;
            case 2:
                products.setPrice(products.getChipsAhoy());
                break;
            case 3:
                products.setPrice(products.getPringles());
                break;
            case 4:
                products.setPrice(products.getMilano());
                break;
            case 5:
                products.setPrice(products.getReeses());
                break;
            case 6:
                products.setPrice(products.getCocaCola());
                break;
            case 7:
                products.setPrice(products.getFanta());
                break;
            case 8:
                products.setPrice(products.getWater());
                break;
            case 9:
                products.setPrice(products.getArizona());
                break;
            case 10:
                products.setPrice(products.getSkittles());
                break;

        }
        return products.getPrice();
    }

    public double balance(double price, double money, Products product){ // balance = bakiye

        while (money<price){
            Scanner scan =new Scanner(System.in);
            System.out.println("Bakiye yetersiz, para eklemek ister misiniz? (Y/N)");

            char onay = scan.next().toUpperCase().charAt(0);

            if (onay=='N'){
                System.out.println("Bakiyeniz " +money);
                System.out.println("Tesekkur eder tekrar bekleriz...");
                break;
            }else if (onay=='Y'){
                System.out.println("Bakiyeniz "+money);
                System.out.println("Ne kadar eklemek istesiniz?");
                money=money+scan.nextDouble();
                System.out.println("Hesabinizda "+money+" dollar var ");

                price = select(product);

            }else{
                System.out.println("Lutfen 'Y' veya 'N' seciniz...");
            }

        }
        return money;
    }
            // 'almak' anlaminda
    public void purchase(double price, double money, Products product){

        while (money>=product.getPrice()){
            money -= product.getPrice();
            System.out.println("Hesabinizda "+money+ " dollar var");

            Scanner scan = new Scanner( System.in);
            System.out.println("Alisverise devam etmek ister misiniz ? (Y/N)");
            char onay = scan.next().toUpperCase().charAt(0);

            if (onay=='N'){
                System.out.println("Tesekkur eder, yine bekleriz...");
                break;
            }else if (onay=='Y'){
                product.setPrice(select(product));
                money=balance(product.getPrice(),money,product);
            }else{
                System.out.println("Lutfen 'Y' veya 'N' giriniz...");
            }


        }

    }


}
