// Importa as classes necessárias da biblioteca lit
import { html, css, LitElement } from 'lit';

// Define um novo componente chamado DashboardCounterLabel
class DashboardCounterLabel extends LitElement {

  // Define os estilos CSS do componente
  static get styles() {
    return css`
      :host {
        position: relative;
        text-align: center;
        height: calc(18vh - 64px); /* altura proporcional à janela */
        min-height: 180px;         /* altura mínima fixa */
        display: block;
      }

      /* Diferentes cores para o dígito dependendo da classe aplicada */
      :host(.green) .count-digit {
        color: #55bf3b;
      }

      :host(.red) .count-digit {
        color: #ff473a;
      }

      :host(.blue) .count-digit {
        color: #1877f3;
      }

      :host(.gray) .count-digit {
        color: rgba(45, 71, 105, 0.7);
      }

      .content {
        padding: 10px;
      }

      .count-wrapper {
        display: block;
        text-align: center;
        padding-top: 12px;
        margin-bottom: 18px;
      }

      .count-digit {
        font-size: 44px; /* tamanho grande para o número */
      }

      .subtitle {
        color: var(--lumo-secondary-text-color);
        font-size: 14px;
      }

      h4 {
        margin: 0;
      }

      .chart-wrapper {
        position: absolute;
        top: 0;
        left: 0;
        height: 120px;
        width: 100%;
      }
    `;
  }

  // Renderização do HTML do componente
  render() {
    return html`
      <!-- Espaço reservado para gráficos (slots) -->
      <div class="chart-wrapper">
        <slot></slot>
      </div>

      <!-- Conteúdo principal do contador -->
      <div class="content">
        <div class="count-wrapper">
          <span id="count" class="count-digit"></span>
        </div>

        <h4 id="title"></h4>
        <div id="subtitle" class="subtitle"></div>
      </div>
    `;
  }

  // Nome do custom element
  static get is() {
    return 'dashboard-counter-label';
  }
}

// Regista o custom element no navegador
customElements.define(DashboardCounterLabel.is, DashboardCounterLabel);
