var container = document.getElementById("root");
function Participante(props) {
    const [numero, setNumero] = React.useState(10);
    function votar() {
        setNumero(numero + 1);
    }
    return (
        <>
            <div>
                <h2>{props.nome}</h2>
                <h3>{numero}</h3>
                <button onClick={votar}>Votar</button>
            </div>
        </>
    );
}
function Votacao() {
    return (
        <>
            <h1>Participantes</h1>
            <Participante nome="Blue Pen" />
            <Participante nome="Blue Red" />
            <Participante nome="Blue Orange" />
        </>
    )
}
ReactDOM.createRoot(container).render(<Votacao />);