package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element{
	
	private static ElementType elemento;
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType rol;
	private Coordenada coordenada;
	
	
	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public Jugador(PlayerType rol) {
		super(ElementType.valueOf(rol.name()));
		this.rol = rol;
		this.elemento=ElementType.valueOf(rol.name());
	}
	
	public String getNombre() {
		return this.rol.toString();
	}
	
	public int getFuerzaParaLuchar() {
		return new Random().nextInt(0,getFuerza());
	}
	
	private int getFuerza() {
		return this.rol.getFuerza();
	}
	
	public int getMagiaParaLuchar() {
		return new Random().nextInt(0,getMagia());
	}
	
	private int getMagia() {
		return this.rol.getMagia();
	}
	
	public int getVelocidadParaLuchar() {
		return new Random().nextInt(1,getVelocidad());
	}
	
	private int getVelocidad() {
		return this.rol.getVelocidad();
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) throws JugadorException {
		if(dinero<0) {
			throw new JugadorException();
		}
		this.dinero = dinero;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		if(pociones<0) {
			throw new JugadorException();
		}
		this.pociones = pociones;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		if(gemas<0) {
			throw new JugadorException();
		}
		this.gemas = gemas;
	}
	
	public String resumen() {
		return String.format("El jugador de rol %s tiene: %s dinero, %s gemas, %s pociones.", this.rol, this.dinero, this.gemas, this.pociones);
	}
	
	public PlayerType getPlayer() {
		return this.rol;
	}
	 
	public int lucha(Jugador j) throws JugadorException {
		
		int res = Constantes.EMPATE;
		
		if(this.getFuerzaParaLuchar()>j.getFuerzaParaLuchar()) {
			if(j.getPociones()>0) {
				if(j.getDinero()>0) {
					res=Constantes.GANA_DINERO;
				}else {
					res=Constantes.GANA_USA_POCIMA;
					j.setPociones(j.getPociones()-1);
				}
				
				this.setDinero(j.getDinero());
				j.setDinero(0);
				
			}else {
				res=Constantes.GANA_MUERE;
				this.setDinero(j.getDinero());
				j.setDinero(0);
				
			}
				
		}else {
			if(this.getPociones()>0) {
				if(this.getDinero()>0) {
					res=Constantes.GANA_DINERO;
				}else {
					res=Constantes.GANA_USA_POCIMA;
					this.setPociones(this.getPociones()-1);
				}
				
				j.setDinero(this.getDinero());
				this.setDinero(0);
				
			}else {
				res=Constantes.GANA_MUERE;
				j.setDinero(this.getDinero());
				this.setDinero(0);
				
			}	
		}
	
		return res;
	}
	
	
	public int encuentraRoca() {
		int res=Constantes.PIERDE_A_LA_ROCA;
		if(this.gemas>0) {
			res=Constantes.ROMPE_ROCA_CON_GEMA;
		}else {
			if(this.getMagia()>=4) {
				res=Constantes.GANA_A_LA_ROCA;
			}
		}
		return res;
	}
	
	public void encuentraDinero() {
		this.dinero++;
	}
	
	public void encuentraPocion() {
		this.pociones++;
	}
	
	public void encuentraGema() {
		this.gemas++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
