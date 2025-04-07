import { createFileRoute } from '@tanstack/react-router'
import '../styles.css'

export const Route = createFileRoute('/')({
  component: App,
})

function App() {
  return (
    <div className='dark'>
      <div className='h-[100vh] bg-background'></div>
    </div>
  )
}
