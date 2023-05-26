package elementos;

import java.util.Objects;

public class Element{
	
	private ElementType elemento;

	public Element(ElementType elemento) {
		super();
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return "Element [elemento=" + elemento + "]";
	}

	public ElementType getType() {
		return elemento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elemento);
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj!=null && obj instanceof Element && obj.hashCode()==this.hashCode();
	}
	
	
	
}
