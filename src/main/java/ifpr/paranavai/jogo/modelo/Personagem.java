package ifpr.paranavai.jogo.modelo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import ifpr.paranavai.jogo.principal.Principal;

public class Personagem extends ElementoGrafico {
    private static final int DESLOCAMENTO = 3;
    private static final int POSICAO_INICIAL_EM_X = 100;
    private static final int POSICAO_INICIAL_EM_Y = 100;

    protected int deslocamentoEmX;
    protected int deslocamentoEmY;
    protected int pontuacao;
    protected int vida = 3;

    private ArrayList<Tiro> tiros;

    public Personagem() {
        this.carregar();
        super.setPosicaoEmX(POSICAO_INICIAL_EM_X);
        super.setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<Tiro>();
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/espaconave.png"));
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        if (super.posicaoEmX < 0) {
            super.posicaoEmX = 0;
        } else if (super.posicaoEmX + larguraImagem > Principal.LARGURA_DA_JANELA) {
            super.posicaoEmX = Principal.LARGURA_DA_JANELA - larguraImagem;
        } else if (super.posicaoEmY < 0) {
            super.posicaoEmY = 0;
        } else if (super.posicaoEmY + alturaImagem > Principal.ALTURA_DA_JANELA) {
            super.posicaoEmY = (Principal.ALTURA_DA_JANELA - alturaImagem) + -80;
        } else {
            super.posicaoEmX += this.deslocamentoEmX;
            super.posicaoEmY += this.deslocamentoEmY;
        }    
    }


    public void atirar() {
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getAlturaImagem() / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = DESLOCAMENTO;
                break;
            default:
                break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_A:
                deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
                deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = 3;
    }
    
}
