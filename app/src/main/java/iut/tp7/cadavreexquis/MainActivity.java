package iut.tp7.cadavreexquis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /** Nom de la partie */
    private EditText saisieNom;
    /** Type de partie */
    private Spinner spinTypePartie;
    private ArrayAdapter<String> adapdateurTypePartie;
    /** Nombre de manches */
    private Button bpManchesMoins;
    private TextView txtManches;
    private Button bpManchesPlus;
    /** Nombre de joueurs */
    private Button bpJoueursMoins;
    private TextView txtJoueurs;
    private Button bpJoueursPlus;
    /** Choix de la forme de la phrase */
    private Button bpFormePhrase;
    /** Thème de la partie */
    private Spinner spinTheme;
    private ArrayAdapter<String> adapdateurTheme;
    /** Langue de la partie */
    private Spinner spinLangue;
    private ArrayAdapter<String> adapdateurLangue;
    /** Confidentialité de la partie */
    private Spinner spinConfidentialite;
    private ArrayAdapter<String> adapdateurConfidentialite;

    /** Bouton inviter un ami */
    private Button bpInviter;
    private TextView txtAmis;

    /** Boutons de contrôle */
    private Button bpAnnuler;
    private Button bpCreer;

    /** Nombre minimum de manches */
    public final int NB_MANCHES_MIN = 1;
    /** Nombre par défaut de manches */
    public final int NB_MANCHES_DEFAUT = 5;

    /** Nombre minimum de joueurs */
    public final int NB_JOUEURS_MIN = 3;
    /** Nombre par défaut de joueurs */
    public final int NB_JOUEURS_DEFAUT = 5;
    /** Nombre maximum de joueurs */
    public final int NB_JOUEURS_MAX = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* On lie les attributs avec la vue */
        saisieNom = (TextView) findViewById(R.id.saisieNom);
        spinTypePartie = (Spinner) findViewById(R.id.spinTypePartie);
        bpManchesMoins = (Button) findViewById(R.id.bpManchesMoins);
        txtManches = (TextView) findViewById(R.id.txtManches);
        bpManchesPlus = (Button) findViewById(R.id.bpManchesPlus);
        bpJoueursMoins = (Button) findViewById(R.id.bpJoueursMoins);
        txtJoueurs = (TextView) findViewById(R.id.txtJoueurs);
        bpJoueursPlus = (Button) findViewById(R.id.bpJoueursPlus);
        bpFormePhrase = (Button) findViewById(R.id.bpFormePhrase);
        spinTheme = (Spinner) findViewById(R.id.spinTheme);
        spinLangue = (Spinner) findViewById(R.id.spinLangue);
        spinConfidentialite = (Spinner) findViewById(R.id.spinConfidentialite);
        bpInviter = (Button) findViewById(R.id.bpInviter);
        txtAmis = (TextView) findViewById(R.id.txtAmis);
        bpAnnuler = (Button) findViewById(R.id.bpAnnuler);
        bpCreer = (Button) findViewById(R.id.bpCreer);

        /* On initialise les spinners */
        adapdateurTypePartie = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.typesPartie));
        adapdateurTypePartie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTypePartie.setAdapter(adapdateurTypePartie);

        adapdateurTheme = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.themes));
        adapdateurTheme.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTheme.setAdapter(adapdateurTheme);

        adapdateurLangue = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.langues));
        adapdateurLangue.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLangue.setAdapter(adapdateurLangue);

        adapdateurConfidentialite = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.confidentialites));
        adapdateurConfidentialite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinConfidentialite.setAdapter(adapdateurConfidentialite);


        // TODO continuer à initialiser

    }


    /**
     * Incrémente le nombre de manches
     * @param view
     */
    public void incrementerNbManches(View view) {
        int nbManches = Integer.valueOf(txtManches.getText().toString());
        nbManches++;
        txtManches.setText(String.valueOf(nbManches));

        // TODO si nbManches correspond à une possibilité des nombres prédéfinis

        bpManchesMoins.setEnabled(true);
    }

    /**
     * Décrémente le nombre de manches s'il est au moins égal à 2
     * @param view
     */
    public void decrementerNbManches(View view) {
        int nbManches = Integer.valueOf(txtManches.getText().toString());
        if (nbManches > NB_MANCHES_MIN) { // on vérifie le nombre de manches
            nbManches--;
            txtManches.setText(String.valueOf(nbManches));
            if (nbManches == NB_MANCHES_MIN) { // si on est au minimum possible, on désactive le bouton moins
                bpManchesMoins.setEnabled(false);
            }
        }

        // TODO si nbManches correspond à une possibilité des nombres prédéfinis
    }

    /**
     * Incrémente le nombre de joueurs
     * @param view
     */
    public void incrementerNbJoueurs(View view) {
        int nbJoueurs = Integer.valueOf(txtJoueurs.getText().toString());
        if (nbJoueurs < NB_JOUEURS_MAX) {
            nbJoueurs++;
            txtJoueurs.setText(String.valueOf(nbJoueurs));
            if (nbJoueurs == NB_JOUEURS_MAX) { // nombre max de joueurs
                bpJoueursPlus.setEnabled(false);
            }
        }

        bpJoueursMoins.setEnabled(true);
    }

    // TODO



}
