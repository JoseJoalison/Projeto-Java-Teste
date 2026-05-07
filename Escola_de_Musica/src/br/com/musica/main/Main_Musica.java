package br.com.musica.main;


import br.com.musica.classes.CursoMusicaFactory;
import br.com.musica.interfaces.*;

public class Main_Musica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CursoMusicaFactory objCursoMusica = new CursoMusicaFactory();

			IGestaoCurso curso = objCursoMusica.gerarCurso("CursoBateria", 5, 5, "");

			// avaliação
			curso.provafinal().avaliacao();

			// iniciar / encerrar com apresentação na camada de UI (Main)
			String nomeCurso = ((br.com.musica.classes.Curso) curso).getNome();
			System.out.println("Iniciando curso: " + nomeCurso);
			curso.iniciarCurso();
			System.out.println("Curso iniciado: " + nomeCurso);

			System.out.println("Encerrando curso: " + nomeCurso);
			curso.encerrarCurso();
			System.out.println("Curso encerrado: " + nomeCurso);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} 
	}

}
