package model.estrutura;

import java.lang.Exception;
import model.estrutura.No;

public class ListaDupla<T> {

	private No<T> inicio = null;
	private No<T> fim = null;

	public void append(T elemento) {
		No<T> buffer = new No<>(elemento);
		if (this.fim == null) {
			this.fim = buffer;
			this.inicio = buffer;
		} else {
			No<T> ex_ultimo = this.fim;
			ex_ultimo.setProximo(buffer);
			buffer.setAnterior(ex_ultimo);
			this.fim = buffer;
		}
	}

	public No<T> get(int index) throws IllegalArgumentException {
		int i = 0;
		if (this.inicio == null)
			throw new IllegalArgumentException("Nao existe item na lista.");

		No<T> buffer = this.inicio;

		for (i = 0; i < index; i++) {
			if (buffer.getProximo() == null)
				break;
			buffer = buffer.getProximo();
		}

		if (i < index)
			throw new IllegalArgumentException("O indice informado nao existe");

		return buffer;
	}

	public int index(T elemento) throws IllegalArgumentException {
		if (this.inicio == null)
			throw new IllegalArgumentException("Nao existe item na lista.");

		int index = 0;

		if (this.inicio.getValor().equals(elemento))
			return index;

		No<T> buffer = this.inicio;

		do {
			if (buffer.getValor().equals(elemento)) {
				return index;
			}
			buffer = buffer.getProximo();
			index++;
		} while (buffer != null);

		throw new IllegalArgumentException("Item nao encontrado.");
	}

	public void insert(int index, T elemento) throws IllegalArgumentException {
		if (index == 0) {
			No<T> novo = new No<>(elemento);
			if (this.inicio == null) {
				this.inicio = novo;
				this.fim = novo;
			} else {
				No<T> ex_inicio = this.inicio;
				novo.setProximo(ex_inicio);
				this.inicio = novo;
				novo.setProximo(ex_inicio);
				ex_inicio.setAnterior(novo);
			}
		} else {
			this.insert(this.get(--index), elemento);
		}
	}

	public void insert(No<T> item, T elemento) throws IllegalArgumentException {
		No<T> novo = new No<>(elemento);
		No<T> proximo = item.getProximo();
		item.setProximo(novo);
		novo.setProximo(proximo);
		proximo.setAnterior(novo);
		novo.setAnterior(item);
	}

	public void prepend(T elemento) {
		No<T> buffer = new No<>(elemento);
		if (this.fim == null) {
			this.fim = buffer;
			this.inicio = buffer;
		} else {
			No<T> ex_primeiro = this.inicio;
			this.inicio = buffer;
			buffer.setProximo(ex_primeiro);
			ex_primeiro.setAnterior(buffer);
		}
	}

	public void insertOrdenado(T elemento) {
		No<T> novo = new No<>(elemento);

		// lista vazia
		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
			return;
		}

		String valor = elemento.toString();

		// inserir no início
		if (valor.compareToIgnoreCase(this.inicio.getValor().toString()) < 0) {
			novo.setProximo(this.inicio);
			this.inicio.setAnterior(novo);
			this.inicio = novo;
			return;
		}

		No<T> atual = this.inicio;

		while (atual.getProximo() != null &&
				valor.compareToIgnoreCase(atual.getProximo().getValor().toString()) > 0) {
			atual = atual.getProximo();
		}

		// inserir
		novo.setProximo(atual.getProximo());
		novo.setAnterior(atual);

		if (atual.getProximo() != null) {
			atual.getProximo().setAnterior(novo);
		} else {
			this.fim = novo;
		}

		atual.setProximo(novo);
	}

	public void remove(int index) {
		if (index == 0) {
			this.inicio.setValor(null);
			this.inicio.setAnterior(null);
			if (this.inicio.getProximo() == null) {
				this.inicio = null;
				this.fim = null;
			} else {
				No<T> buffer = this.inicio.getProximo();
				this.inicio.setProximo(null);
				this.inicio = buffer;
			}
			return;
		}

		No<T> anterior = this.get(index - 1);
		No<T> item = anterior.getProximo();
		No<T> proximo = item.getProximo();
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		item.setAnterior(null);
		item.setProximo(null);
		item.setValor(null);
	}

	public int total() {
		if (this.inicio == null)
			return 0;

		No<T> buffer = this.inicio;
		int total_elementos = 0;

		do {
			total_elementos++;
			buffer = buffer.getProximo();
		} while (buffer != null);
		return total_elementos;
	}

	public String imprimirAsc() {
		if (this.inicio == null)
			return "[]";

		StringBuilder sb = new StringBuilder("[");
		No<T> atual = this.inicio;

		while (atual != null) {
			sb.append(atual.getValor());
			if (atual.getProximo() != null) {
				sb.append(", ");
			}
			atual = atual.getProximo();
		}

		sb.append("]");
		return sb.toString();
	}

	public String imprimirDesc() {
		if (this.fim == null)
			return "[]";

		StringBuilder sb = new StringBuilder("[");
		No<T> atual = this.fim;

		while (atual != null) {
			sb.append(atual.getValor());
			if (atual.getAnterior() != null) {
				sb.append(", ");
			}
			atual = atual.getAnterior();
		}

		sb.append("]");
		return sb.toString();
	}

	@Override
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		No<T> buffer = this.inicio;
		builder.append(buffer.getValor());

		while (buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}

		builder.append("]");
		return builder.toString();
	}
}