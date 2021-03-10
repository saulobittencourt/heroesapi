
package com.reactive.heroesapi.exceptions;

/**
 * Uma exceção de negócio, que é lançada da camada <tt>service</tt> e exposta para os
 * clientes da camada quando uma regra de negócio é violada.
 * Exemplos:
 * <ul>
 * <li>Atributo obrigatório não informado, com valor inválido, fora do esperado etc.</li>
 * <li>Dependências de negócio, como por exemplo "O aluno está com débitos, e por isso não pode fazer nova matrícula."</li>
 * </ul>
 */
public class ServiceBusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -5997543516314067515L;

    /**
     * Constrói ServiceBusinessException passando uma detail message
     *
     * @see {@link Exception#Exception(String)}
     */
    public ServiceBusinessException(String message) {
        super(message);
    }

    /**
     * Constrói ServiceBusinessException uma detail message e com a sua causa.
     *
     * @see {@link Exception#Exception(String, Throwable)}
     */
    public ServiceBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constrói ServiceBusinessException com a sua causa
     *
     * @see {@link Exception#Exception(Throwable)}
     */
    public ServiceBusinessException(Throwable cause) {
        super(cause);
    }

}
