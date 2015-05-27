
package modelos;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Turma 
{
    private int codTurma;
    private String nomeTurma;
    private String curso;
    private String turno;
    private ArrayList<Convidado> convidado= new ArrayList();

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public ArrayList<Convidado> getConvidado() {
        return convidado;
    }
    
    
    public void setConvidado(ArrayList<Convidado> convidado) {
        this.convidado = convidado;
    }
    public void setConvidado(Convidado convidado) {
        this.convidado.add(convidado);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
}
