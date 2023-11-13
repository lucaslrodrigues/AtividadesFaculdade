var container = document.getElementById("root");
function Login() {
    // const [numero, setNumero] = React.useState(10);
    // function votar() {
    //     setNumero(numero + 1);
    // }
    return (
        <>
            <div>
                <h2>{props.msg}</h2>
            </div>
            <h1>Teste</h1>
        </>
    );
}
function Logar() {
    console.log("Logado")
}
function LoginArea() {
    return (
        <>
            <Login msg="Usuario" />
            <Login msg="Senha" />
            <button onClick={Logar()}>Logar</button>
        </>
    )
}
ReactDOM.createRoot(container).render(<LoginArea />);