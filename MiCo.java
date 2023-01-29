package dam.net.jmfm.ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public abstract class MiCo {
	public static enum ColorTexto {
		CT_NEGRO("30"), CT_ROJO("31"), CT_VERDE("32"), CT_MARRON("33"), CT_AZUL("34"), CT_PURPURA("35"), CT_CYAN("36"),
		CT_BLANCO("37"), CT_NEGRO_CLARO("90"), CT_ROJO_CLARO("91"), CT_VERDE_CLARO("92"), CT_MARRON_CLARO("93"),
		CT_AZUL_CLARO("94"), CT_PURPURA_CLARO("95"), CT_CYAN_CLARO("96"), CT_BLANCO_CLARO("97");

		private String color_texto;

		private ColorTexto(String color) {
			this.color_texto = color;
		}

		public String getColorTexto() {
			return color_texto;
		}
	}

	public static enum ColorFondo {
		CF_NEGRO("40"), CF_ROJO("41"), CF_VERDE("42"), CF_MARRON("43"), CF_AZUL("44"), CF_PURPURA("45"), CF_CYAN("46"),
		CF_BLANCO("47"), CF_NEGRO_CLARO("100"), CF_ROJO_CLARO("101"), CF_VERDE_CLARO("102"), CF_MARRON_CLARO("103"),
		CF_AZUL_CLARO("104"), CF_PURPURA_CLARO("105"), CF_CYAN_CLARO("106"), CF_BLANCO_CLARO("107");

		private String color_fondo;

		private ColorFondo(String color) {
			this.color_fondo = color;
		}

		public String getColorFondo() {
			return color_fondo;
		}
	}

	static void setColor(MiCo.ColorTexto ct, MiCo.ColorFondo cf) {
		String cadena = "\033[" + ct.getColorTexto() + ";" + cf.getColorFondo() + "m";
		System.out.print(cadena);
	}

	static void setTexto(MiCo.ColorTexto ct) {
		String cadena = "\033[" + ct.getColorTexto() + "m";
		System.out.print(cadena);
	}

	static void setTexto(int texto) {
		System.out.print("\033[38;5;" + texto + "m");
	}

	static void setTexto(int r, int g, int b) {
		System.out.print("\033[38;2;" + r + ";" + g + ";" + b + "m"); // \033[38;2;r;g;b;m
	}

	static void setFondo(MiCo.ColorFondo cf) {
		String cadena = "\033[" + cf.getColorFondo() + "m";
		System.out.print(cadena);
	}

	static void setFondo(int fondo) {
		System.out.print("\033[48;5;" + fondo + "m");
	}

	static void setFondo(int r, int g, int b) {
		System.out.print("\033[48;2;" + r + ";" + g + ";" + b + "m");
	}

	static void setNormal() {
		String cadena = "\033[m";
		System.out.println(cadena);
	}

	static void setNegrita(boolean activar) {
		if (activar == true) {
			System.out.print("\033[1m");
		} else {
			System.out.print("\033[22m");
		}
	}

	static void setCursiva(boolean activar) {
		if (activar == true) {
			System.out.print("\033[3m");
		} else {
			System.out.print("\033[23m");
		}
	}

	static void setSubrayado(boolean activar) {
		if (activar == true) {
			System.out.print("\033[4m");
		} else {
			System.out.print("\033[24m");
		}
	}

	static void setParpadeo(boolean activar) {
		if (activar == true) {
			System.out.print("\033[5m");
		} else {
			System.out.print("\033[25m");
		}
	}

	static void setTachado(boolean activar) {
		if (activar == true) {
			System.out.print("\033[9m");
		} else {
			System.out.print("\033[29m");
		}
	}

	static void setInverso(boolean activar) {
		if (activar == true) {
			System.out.print("\033[7m");
		} else {
			System.out.print("\033[27m");
		}
	}

	static void setOculto(boolean activar) {
		if (activar == true) {
			System.out.print("\033[8m");
		} else {
			System.out.print("\033[28m");
		}
	}

	static void cls() {
		System.out.print("\033[2J");
	}

	public static void setCursor(int linea, int columna) {
		String cadena = "\033[" + linea + ";" + columna + "H";
		System.out.print(cadena);
	}

	static void set132Col(boolean activar) {
		if (activar == true) {
			System.out.print("\033[?3h");
		} else {
			System.out.print("\033[?3l");
		}
	}

	static void cursorVisible(boolean activar) {
		if (activar == true) {
			System.out.print("\033[?25h");
		} else {
			System.out.print("\033[?25l");
		}
	}

	static void sonido(int volumen, int duracion, int... notas) {
		String cadena = "\033[" + volumen + ";" + duracion;
		for (int i = 0; i < notas.length; i++) {
			cadena += ";" + notas[i];
		}
		cadena += ",~";
		System.out.print(cadena);
	}

	static void setTitulo(String titulo) {
		String cadena = "\033]2;" + titulo + "\033\\";
		System.out.print(cadena);
	}
	

}
