import java.util.*;
class Product{
    int productID;
    String productName;
    double price;
    public Product(int productID,String productName,double price){
        this.productID=productID;
        this.productName=productName;
        this.price=price;
    }
    public void display(){

        System.out.println("Product ID: "+productID);
        System.out.println("Product name: "+productName);
        System.out.println("Product price: "+price);
    }
}
public class MergeSortProduct{
    public static Product[] mergeSorting(Product[] arr){
        if(arr.length<=1){
            return arr;
        }
        int mid=arr.length/2;
        Product[] left=mergeSorting(Arrays.copyOfRange(arr,0,mid));
        Product[] right=mergeSorting(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    public static Product[] merge(Product[] left,Product[] right){
        Product[] joined=new Product[left.length+right.length];
        int i=0,j=0,k=0;
        while(i<left.length&&j<right.length){
            if(left[i].price<right[j].price){
                joined[k++]=left[i++];
            }else{
                joined[k++]=right[j++];
            }
        }
        while(i<left.length){
            joined[k++]=left[i++];
        }
        while(j<right.length){
            joined[k++]=right[j++];
        }
        return joined;
    }
    public static void main(String[] args){
        Product[] products={new Product(101,"Lipstick",200),
                            new Product(102,"dress",2000),
                            new Product(103,"bag",1500)
                        };
        System.out.println("----------Your product lists--------");
        for(Product p:products){
            p.display();
        }

        
        System.out.println("----------Your product lists after sorting prices");
        products=mergeSorting(products);
        for(Product p:products){
            p.display();
        }

    }
}