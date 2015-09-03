/*
 * BookSoft v 1.0
 */
package books;
import java.util.Scanner;

public class BookS {
        String name, autor, area; String sel_area, sel_act;          
        int  añoPubli, code, quanti, totalBook;        
        int ind_default, total_pres;        //Banderas
        Scanner input = new Scanner(System.in);
    void area(){
        do{ System.out.print("| Ingrese el área respectiva: 1.Química |2.Física |3.Tecnología |4.Cálculo |5.Programación |\n| Selección: ");
            sel_area=input.nextLine();
            switch(sel_area){
                case "1":   area= "Quimica";
                            ind_default=0;
                            break;
                case "2": area= "Física";
                            ind_default=0;
                            break;                    
                case "3": area= "Tecnología";
                            ind_default=0;
                            break;
                case "4": area= "Cálculo";                    
                            ind_default=0;
                            break;
                case "5": area= "Programación";                    
                            ind_default=0;
                            break;
                default:    ind_default=1; 
                            System.out.print("Advertencia!\n| Opción inválida! |");
            }
        }while(ind_default==1);
    } 
    void registro (int i){
            ind_default=0;
        System.out.println("\nRegistro #"+(i+1));
        System.out.print("| Ingrese nombre: ");
        name=input.nextLine();
        System.out.print("| Ingrese autor: ");
        autor=input.nextLine();
        System.out.print("| Ingrese año de publicación: ");
        añoPubli=input.nextInt();
        System.out.print("| Ingrese código: ");
        code=input.nextInt();  
        System.out.print("| Ingrese cantidad: ");
        quanti=input.nextInt(); 
        input.nextLine();
        area();    
    }
    void mostrarLibro(int i){        
        System.out.println("\nRegistro #"+(i+1)+":\n| Nombre:"+name+"| Autor: "+autor+"| Publicado en: "+añoPubli+"| Código: "+code+"| Cantidad: "+quanti+"| Área: "+area+" |");          
    }  
    void actualizarLibro(){
        do{ ind_default=0;
            System.out.print("\n¿Qué desea actualizar?\n| 1.Nombre |2.Autor |3.Publicación |4.Código |5.Cantidad |6.Área |\nSelección: ");          
            sel_act=input.nextLine();         
            switch(sel_act){
            case "1":   System.out.print("Ingrese nombre: ");
                        input.nextLine();name=input.nextLine(); 
                        ind_default=0;
                    break;
            case "2":   System.out.print("Ingrese autor: ");
                        input.nextLine();autor=input.nextLine(); 
                        ind_default=0;
                    break;
            case "3":   System.out.print("Ingrese año de publicación: ");
                        input.nextLine(); añoPubli=input.nextInt(); 
                        ind_default=0;
                    break;
            case "4":   System.out.print("Ingrese código: ");
                        input.nextLine(); code=input.nextInt(); 
                        ind_default=0;
                    break;
            case "5":   System.out.print("Ingrese cantidad: ");
                        input.nextLine(); quanti=input.nextInt(); 
                        ind_default=0;
                        break;
            case "6":   System.out.print("\n");
                        area(); 
                        ind_default=0;
                        break;    
            default:    System.out.println("\nAdvertencia!\n| ¡ERROR! Actualización NO válida. |");                        
                        ind_default=1;
                        break;   
            }
        }while(ind_default==1);
    }
    
        static public class Prestamo extends BookS{
            String cc;
            
        }
    
        public static void main(String[] args) {
             int  k=0;
            String sel ;int sel3, sel4,ind_equal, totalBooks=3, totalBooksPres=-1;//Total de registros. OJO! Cambiarlos a 10.
            String ind_name, ind_ced, ind_pres;                         //k:total de libros prestados
            Scanner input = new Scanner(System.in);
            BookS[] book = new BookS[10];
            Prestamo[] bookPres = new Prestamo [10];
        book[0] = new BookS();      book[1] = new BookS();      book[2] = new BookS();  
        book[0].name="Camilo";      book[1].name="Jess";        book[2].name="Gloria";
        book[0].autor="1";          book[1].autor="2";          book[2].autor="3";
        book[0].añoPubli=1;         book[1].añoPubli=2;         book[2].añoPubli=3;
        book[0].code=1;             book[1].code=2;             book[2].code=3; 
        book[0].quanti=1;           book[1].quanti=2;           book[2].quanti=3;
        book[0].area="1";           book[1].area="2";           book[2].area="3";         
        
        do{  
            System.out.println("\nMenú Principal");
            System.out.print("| 1.Ingresar libro |2.Actualizar libro |3.Eliminar libro |4.Buscar libro |\n| 5.Préstamo de libro |6. Devolución libros prestados |7. Mostrar libros prestados |\n| Selección: ");
            sel=input.nextLine(); 
            switch (sel){
            case "1":     for(int i=totalBooks;i<(totalBooks+1);i++){
                            book[i] = new BookS();
                            book[i].registro(i);
                        }
                        totalBooks++;
                        break;
            case "2":   System.out.println("\nActualización ");
                        System.out.print("| Ingrese nombre del libro: ");
                        ind_name=input.nextLine();                    
                        for (int i=0;i<totalBooks;i++){
                                ind_equal=ind_name.compareTo(book[i].name);
                            if (ind_equal==0){  
                                    book[i].actualizarLibro();
                                    book[i].mostrarLibro(i);
                                    break;
                            }
                            if (i==totalBooks-1){
                                System.out.println("\nAdvertencia!\n| ¡ERROR! El nombre no coincide. |");
                                break;
                            }
                        }
                        break;
            case "3":   System.out.println("\nLimpieza de Registros");         //Hacer prueba con 3 libros
                        System.out.print("| Ingrese nombre del libro: ");
                        ind_name=input.nextLine();                    
                        for (int i=0;i<totalBooks;i++){
                                ind_equal=ind_name.compareTo(book[i].name);
                            if (ind_equal==0){  
                                for (int j=i;j<totalBooks;j++){ 
                                  if (j!=(totalBooks-1)){
                                      book[j].name=book[j+1].name;                                      
                                  } else {
                                      totalBooks=totalBooks-1;                                                                         
                                  }
                                }
                                System.out.println("\nAdvertencia!\n| El registro ha sido borrado. |");
                                break;
                            }
                            if (i==totalBooks-1){
                                System.out.println("\nAdvertencia!\n| ¡ERROR! El nombre no coincide. |");
                            }
                        }            
                        break;
            case "4":   System.out.println("\nBúsqueda ");
                        System.out.print("| Ingrese nombre del libro: ");
                        ind_name=input.nextLine();                    
                        for (int i=0;i<totalBooks;i++){
                            ind_equal=ind_name.compareTo(book[i].name);
                            if (ind_equal==0){  
                                    book[i].mostrarLibro(i); break;
                            }
                            if (i==totalBooks-1){
                                System.out.println("\nAdvertencia!\n| ¡ERROR! El nombre no coincide. |");                                
                            }
                        } 
                        break;
            case "5":   
                        bookPres[k] = new Prestamo();                    
                        System.out.println("\nPréstamo ");
                        System.out.print("| Ingrese su cédula: ");
                        ind_ced=input.nextLine(); bookPres[k].cc=ind_ced;
                        do{ sel4=0;
//                            System.out.println("\nBúsqueda ");
                            System.out.print("| Ingrese nombre del libro: ");
                            ind_name=input.nextLine(); 
                            for (int i=0;i<totalBooks;i++){
                                ind_equal=ind_name.compareTo(book[i].name);
                                if (ind_equal==0){
                                    if (book[i].quanti!=0){ 
                                        book[i].mostrarLibro(i);
                                        System.out.print("| 1.¿Continuar con préstamo? |2. ¿Regresar a búsqueda? |\n| Selección: ");
                                        ind_pres=input.nextLine();
                                        switch(ind_pres){
                                            case "1":   book[i].quanti=book[i].quanti-1;        //Resto de inventario
                                                        bookPres[k].name=book[i].name;      //Asignación 
                                                        bookPres[k].autor=book[k].autor;
                                                        bookPres[k].añoPubli=book[k].añoPubli;     
                                                        bookPres[k].code=book[k].code;
                                                        bookPres[k].quanti=1;
                                                        bookPres[k].area=book[k].area;
                                                        System.out.print("\n| Préstamo exitoso! |\n");
                                                        k=k+1;
                                                        break;
                                            case "2":   sel4=1;
                                                        break;
                                            default:    System.out.println("\nAdvertencia!\n| Opción inválida! |");
                                                        break;
                                        }
                                    }else{
                                        System.out.print("| No disponible! |");                                        
                                    }
                                break;
                                }
                                if (i==totalBooks-1){
                                    System.out.println("\nAdvertencia!\n| ¡ERROR! El nombre no coincide. |");                                
                                }
                            }
                        }while (sel4==1);
                        break;
            case "6":   
                do{ sel4=0;
                        System.out.println("\nDevolución\nBúsqueda ");
                        System.out.print("| Ingrese nombre del libro: ");
                        ind_name=input.nextLine(); 
                        if (k!=0){    
                            for (int i=0;i<k;i++){
                                ind_equal=ind_name.compareTo(book[i].name);
                                if (ind_equal==0){                                    
                                        book[i].mostrarLibro(i);
                                        System.out.print("| 1.¿Continuar con devolución? |2. ¿Regresar a búsqueda? |\n| Selección: ");
                                        ind_pres=input.nextLine();
                                        switch(ind_pres){
                                            case "1":   book[i].quanti=book[i].quanti+1;        //Sumo al inventario.
                                                        k=k-1;                  //Resto inventario de prestados.                                                        
                                                        bookPres[i]=bookPres[i+1]; 
                                                        System.out.print("\n| Devolución exitosa! |\n");
                                                       
                                                        break;
                                            case "2":   sel4=1;
                                                        break;
                                            default:    System.out.println("\nAdvertencia!\n| Opción inválida! |");
                                                        break;
                                        }                                    
                                break;
                                }
                                if (i==totalBooks-1){
                                    System.out.println("\nAdvertencia!\n| ¡ERROR! El nombre no coincide. |");                                
                                }
                            }    
                        }
                        else{
                            System.out.println("\nAdvertencia!\n| No hay libros prestados! |");
                        }
                }while (sel4==1);
                break;    
            case "7": System.out.print("\nTotal libros prestados: "+k); 
                      System.out.print("\n");  
                if (k!=0){
                    for (int i=0;i<k;i++){                            
                            bookPres[i].mostrarLibro(i);
                            System.out.print("| Cédula: "+bookPres[i].cc);
                    }
                } 
                else{
                    System.out.println("\nAdvertencia!\n| No hay libros prestados! |");
                }
                       
                        break;    
            default:    System.out.println("\nAdvertencia!\n| Opción inválida! |");
                        break;
            }        
        System.out.print("\n\n¿Qué desea hacer?\n| 1.Regresar al Menú Principal |2.Salir |\n| Selección: ");
        sel3=input.nextInt();        
        input.nextLine();
        }while(sel3==1);        
    }    
}
