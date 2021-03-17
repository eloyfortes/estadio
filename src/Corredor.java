

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread{
   
    int pessoaid;
    int corredor = 200;
    private Semaphore semaforo;
    int ingressos;
    
    public Corredor(int i, Semaphore semaforo, int ingressos ){
    	this.ingressos = ingressos;
        this.pessoaid = i;
        this.semaforo = semaforo;
    }
    
    @Override
    public void run(){
    	logar();
          
    }  
    public void logar () {
    	if (ingressos != 0 ) {
    	// logando
	    	try {
	    		Random random = new Random();
	    		int numero = random. nextInt(2000) + 50;
				Thread.sleep(numero);
				comprar();  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    
    
    
    private void comprar(){
    	Random random = new Random();
    	try {
    		
    		int numero = random. nextInt(3000) + 1000;
			Thread.sleep(numero); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
   
        System.out.println("A pessoa "+pessoaid+" comprou "+ this.ingressos +" ingressos ");
        this.finalizar();
    
    } 
    
   private void finalizar() {
	   try {
           semaforo.acquire();
      
       } catch (InterruptedException ex) {
           Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
       semaforo.release();
       }
    }
  

   }