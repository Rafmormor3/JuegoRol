package elementos;

import java.util.Objects;

import logicaJuego.Constantes;

public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada() {
		super();
	}

	public Coordenada(int x, int y) {
		this();
		if(this.x<0 || this.x>Constantes.TAMANNO || this.y<0 || this.y>Constantes.TAMANNO) {
			this.x=0;
			this.y=0;
		}else {
			this.x = x;
			this.y = y;
		}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj || obj!=null && obj instanceof Coordenada && obj.hashCode()==this.hashCode();
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
	
	public boolean goRight() {
		boolean res=true;
		if(this.x==Constantes.TAMANNO) {
			res=false;
		}else {
			this.x++;
		}
		return res;
	}
	
	
	public boolean goLeft() {
		boolean res=true;
		if(this.x== -(Constantes.TAMANNO)) {
			res=false;
		}else {
			this.x--;
		}
		return res;
	}
	
	public boolean goUp() {
		boolean res=true;
		if(this.y==-Constantes.TAMANNO) {
			res=false;
		}else {
			this.y--;
		}
		return res;
	}
	
	public boolean goDown() {
		boolean res=true;
		if(this.y== Constantes.TAMANNO) {
			res=false;
		}else {
			this.y++;
		}
		return res;
	}
	
	public Coordenada clone() {
		Coordenada c = new Coordenada();
		c=this;
		return c;
	}
	
	
	
	
}
