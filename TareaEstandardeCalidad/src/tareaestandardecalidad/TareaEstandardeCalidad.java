/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaestandardecalidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author TS_Deku
 */
public class TareaEstandardeCalidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    	Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa día de nacimiento: Formato 00 ");
        String dia = entrada.next();
        int diaingresado = Integer.parseInt(dia);
	System.out.println("Ingresa mes de nacimiento: Formato 00 ");
	String mes = entrada.next();
        int mesingresado = Integer.parseInt(mes);
	System.out.println("Ingresa año de nacimiento: Fromato 0000 ");
	int ano = entrada.nextInt();
	entrada.close();
        
	System.out.println("Tu edad es: " + calcularEdad(diaingresado, mesingresado, ano));
        
        calcularProximoCumpleanos(ano+"",mes+"",dia+"");
	}
        
	static int calcularEdad(int dia, int mes, int ano) {
                
		LocalDate fechaHoy = LocalDate.now();
		LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
               
		Period periodo = Period.between(fechaNacimiento, fechaHoy);
                 
                DayOfWeek diadeNacimiento=  fechaNacimiento.getDayOfWeek();
                System.out.println("Usted nacio un dia: "+diadeNacimiento);
                
		return periodo.getYears();
	}
        
       public static void calcularProximoCumpleanos(String ano, String mes, String dia){            
       String fechaparacalcularCumpleaños = ano+"-"+mes+"-"+dia;
           try {
            /*Fecha actual*/
            LocalDate hoy = LocalDate.now();
    
            /*Fecha de nacimiento. Ambas formas son válidas*/
            LocalDate cumpleanos= LocalDate.parse(fechaparacalcularCumpleaños );
            LocalDate proximoCumpleanos = cumpleanos.withYear(hoy.getYear());
    
            /*Si el cumpleaños ya ocurrió este año, agrega 1 año*/
            if (proximoCumpleanos.isBefore(hoy) || proximoCumpleanos.isEqual(hoy)) {
                proximoCumpleanos = proximoCumpleanos.plusYears(1);
            }
    
            Period p = Period.between(hoy, proximoCumpleanos);
            long totalDias = ChronoUnit.DAYS.between(hoy, proximoCumpleanos);
    
            /*Cuando totalDias=365 hoy es el cumpleaños*/
    
            if (totalDias == 365) {
    
                System.out.println("¡Su cumpleaños es hoy. Felicidades!");
    
            } else {
    
                System.out.println("Restan " + p.getMonths() + " meses, y "
                        + p.getDays() + " días para su próximo cumpleaños. ("
                        + totalDias + " días en total)");
            }
            
        }catch (DateTimeParseException exc) {
            System.out.printf("Error: %s no es una fecha válida!%n", fechaparacalcularCumpleaños );
        } 
       
    }
    }
    

