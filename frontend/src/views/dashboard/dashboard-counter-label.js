import { html, css, LitElement } from 'lit';

/**
 * `dashboard-counter-label`
 *
 * Um Web Component baseado em LitElement para exibir um contador com título,
 * subtítulo e uma área opcional de gráfico (via slot).
 *
 * ## Funcionalidades
 * - Mostra um número (contador) destacado.
 * - Permite colorir o número através de classes CSS (`green`, `red`, `blue`, `gray`).
 * - Exibe título e subtítulo configuráveis.
 * - Área superior para gráficos customizados via `<slot>`.
 *
 * ## Uso
 * ```html
 * <dashboard-counter-label class="green">
 *   <!-- Opcional: inserir gráfico dentro do slot -->
 *   <my-chart></my-chart>
 * </dashboard-counter-label>
 * ```
 *
 * ## CSS Custom Properties
 * - `--lumo-secondary-text-color`: Cor do subtítulo.
 *
 * ## Slots
 * - Padrão: conteúdo (ex: gráfico) exibido na área `.chart-wrapper`.
 */
class DashboardCounterLabel extends LitElement {
  /**
   * Estilos do componente.
   * Incluem cores para diferentes estados (verde, vermelho, azul, cinzento),
   * layout do contador, título e subtítulo.
   */
  static get styles() {
    return css`
      :host {
        position: relative;
        text-align: center;
        height: calc(18vh - 64px);
        min-height: 180px;
        display: block;
      }

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
        font-size: 44px;
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

  /**
   * Renderiza o template HTML do componente.
   * Contém:
   * - `chart-wrapper`: área para slot de gráficos.
   * - `count-wrapper`: mostra o valor principal do contador.
   * - `title` e `subtitle`: textos adicionais.
   *
   * @returns {import('lit').TemplateResult} Template do componente
   */
  render() {
    return html`
      <div class="chart-wrapper">
        <slot></slot>
      </div>

      <div class="content">
        <div class="count-wrapper">
          <span id="count" class="count-digit"></span>
        </div>

        <h4 id="title"></h4>
        <div id="subtitle" class="subtitle"></div>
      </div>
    `;
  }

  /**
   * Nome da tag do componente customizado.
   *
   * @returns {string} 'dashboard-counter-label'
   */
  static get is() {
    return 'dashboard-counter-label';
  }
}

customElements.define(DashboardCounterLabel.is, DashboardCounterLabel);
