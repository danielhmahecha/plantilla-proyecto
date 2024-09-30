/**package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "provee")
public class Provee {
    @EmbeddedId
    private ProveePK proveePK;

    public Provee(ProveePK proveePK) {
        this.proveePK = proveePK;
    }

    public Provee() {
        ;
    }

    public ProveePK getProveePK() {
        return proveePK;
    }

    public void setProveePK(ProveePK proveePK) {
        this.proveePK = proveePK;
    }

}